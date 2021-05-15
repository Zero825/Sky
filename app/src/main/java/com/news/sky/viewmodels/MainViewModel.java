package com.news.sky.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.news.sky.api.GamerSkyApi;
import com.news.sky.data.NewsJson;
import com.news.sky.data.NewsPostJson;
import com.news.sky.data.ArticleInformation;
import com.news.sky.util.DataTransform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final static String TAG="MainViewModel";

    private MutableLiveData<List<ArticleInformation>> bannerList;
    private MutableLiveData<List<ArticleInformation>> articleList;
    private int key;

    public MainViewModel() {
        this.key=1;
    }

    public MutableLiveData<List<ArticleInformation>> getBannerList() {
        if(bannerList==null){
            bannerList=new MutableLiveData<>();
            Thread loadThread=new Thread(this::getAppBannerNews);
            loadThread.start();
        }
        return bannerList;
    }

    public MutableLiveData<List<ArticleInformation>> getArticleList() {
        if(articleList==null){
            articleList=new MutableLiveData<>();
            Thread loadThread=new Thread(() -> getAppNewsList(key));
            loadThread.start();
        }
        return articleList;
    }

    public boolean refreshData(){
        return getAppBannerNews()
            && getAppNewsList(this.key=1);
    }

    public boolean loadNextData(){
        this.key++;
        return getAppNewsList(this.key);
    }


    private synchronized boolean getAppBannerNews(){
        Response<NewsJson> response;
        try {
            response = GamerSkyApi.create()
                    .getAppNewsList(NewsPostJson.getAppBannerNewsPostJson())
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if(response.isSuccessful()){
            bannerList.postValue(DataTransform.appNewsListJsonToArticleInformation(response.body()));
            return true;
        }else {
            return false;
        }
    }

    private synchronized boolean getAppNewsList(int key){
        NewsPostJson newsPostJson = NewsPostJson.getAppNewsListPostJson();
        newsPostJson.getRequest().setPageIndex(key);
        Response<NewsJson> response;
        try {
            response = GamerSkyApi.create()
                    .getAppNewsList(newsPostJson)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            if(this.key>2){
                this.key--;
            }
            return false;
        }
        if(response.isSuccessful()){
            NewsJson newsJson =response.body();
            List<ArticleInformation> articleInformations=new ArrayList<>();
            List<ArticleInformation> lastData = articleList.getValue();
            if(key>1){
                articleInformations.addAll(lastData);
            }else {
                ArticleInformation headerArticleInformation=new ArticleInformation("",0,0,new ArrayList<>(), 0,0);
                headerArticleInformation.setType(ArticleInformation.TYPE_HEADER);
                articleInformations.add(headerArticleInformation);
            }
            List<ArticleInformation> moreList = DataTransform.appNewsListJsonToArticleInformation(newsJson);
            if(lastData!=null) {
                int index = articleInformationIndexOf(lastData.get(lastData.size() - 1), moreList);
                if (index != -1) {
                    moreList = moreList.subList(index, moreList.size());
                }else if(key>1) {
                    return false;
                }
            }
            articleInformations.addAll(moreList);
            articleList.postValue(articleInformations);
            return true;
        }else {
            if(this.key>2){
               this.key--;
            }
            return false;
        }
    }

    private int articleInformationIndexOf(ArticleInformation articleInformation,List<ArticleInformation> articleInformations){
        int index=-1;
        for(int i=0;i<articleInformations.size();i++){
            if(articleInformations.get(i).getTime()<articleInformation.getTime()){
               return i;
            }
        }
        return index;
    }


}
