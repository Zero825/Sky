package com.news.sky.data;

import java.util.List;

public class ArticleJson {
    private int errorCode;
    private String errorMessage;
    private List<String> watchTimes;
    private int watchTime;
    private List<Result> result;


    public List<Result> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "AppArticleJson{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", watchTimes=" + watchTimes +
                ", watchTime=" + watchTime +
                ", result=" + result +
                '}';
    }


    public static class Result {

        private String type;
        private String contentType;
        private String templateVersion;
        private String templateURL;
        private String Tag;
        private String Tag_Index;
        private String pageNames;
        private String Title;
        private String Subheading;
        private String Author;
        private String pcPageURL;
        private String CopyFrom;
        private String UpdateTime;
        private String DefaultPicUrl;
        private String GameScore;
        private String GameLib;
        private String TitleIntact;
        private int NodeId;
        private String editor;
        private String AudioUrl;
        private String Content_Index;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getTemplateVersion() {
            return templateVersion;
        }

        public void setTemplateVersion(String templateVersion) {
            this.templateVersion = templateVersion;
        }

        public String getTemplateURL() {
            return templateURL;
        }

        public void setTemplateURL(String templateURL) {
            this.templateURL = templateURL;
        }

        public String getTag() {
            return Tag;
        }

        public void setTag(String tag) {
            Tag = tag;
        }

        public String getTag_Index() {
            return Tag_Index;
        }

        public void setTag_Index(String tag_Index) {
            Tag_Index = tag_Index;
        }

        public String getPageNames() {
            return pageNames;
        }

        public void setPageNames(String pageNames) {
            this.pageNames = pageNames;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getSubheading() {
            return Subheading;
        }

        public void setSubheading(String subheading) {
            Subheading = subheading;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String author) {
            Author = author;
        }

        public String getPcPageURL() {
            return pcPageURL;
        }

        public void setPcPageURL(String pcPageURL) {
            this.pcPageURL = pcPageURL;
        }

        public String getCopyFrom() {
            return CopyFrom;
        }

        public void setCopyFrom(String copyFrom) {
            CopyFrom = copyFrom;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String updateTime) {
            UpdateTime = updateTime;
        }

        public String getDefaultPicUrl() {
            return DefaultPicUrl;
        }

        public void setDefaultPicUrl(String defaultPicUrl) {
            DefaultPicUrl = defaultPicUrl;
        }

        public String getGameScore() {
            return GameScore;
        }

        public void setGameScore(String gameScore) {
            GameScore = gameScore;
        }

        public String getGameLib() {
            return GameLib;
        }

        public void setGameLib(String gameLib) {
            GameLib = gameLib;
        }

        public String getTitleIntact() {
            return TitleIntact;
        }

        public void setTitleIntact(String titleIntact) {
            TitleIntact = titleIntact;
        }

        public int getNodeId() {
            return NodeId;
        }

        public void setNodeId(int nodeId) {
            NodeId = nodeId;
        }

        public String getEditor() {
            return editor;
        }

        public void setEditor(String editor) {
            this.editor = editor;
        }

        public String getAudioUrl() {
            return AudioUrl;
        }

        public void setAudioUrl(String audioUrl) {
            AudioUrl = audioUrl;
        }

        public String getContent_Index() {
            return Content_Index;
        }

        public void setContent_Index(String content_Index) {
            Content_Index = content_Index;
        }

        public String getContentIndex() {
            return Content_Index;
        }



        @Override
        public String toString() {
            return "Result{" +
                    "type='" + type + '\'' +
                    ", contentType='" + contentType + '\'' +
                    ", templateVersion='" + templateVersion + '\'' +
                    ", templateURL='" + templateURL + '\'' +
                    ", Tag='" + Tag + '\'' +
                    ", Tag_Index='" + Tag_Index + '\'' +
                    ", pageNames='" + pageNames + '\'' +
                    ", Title='" + Title + '\'' +
                    ", Subheading='" + Subheading + '\'' +
                    ", Author='" + Author + '\'' +
                    ", pcPageURL='" + pcPageURL + '\'' +
                    ", CopyFrom='" + CopyFrom + '\'' +
                    ", UpdateTime='" + UpdateTime + '\'' +
                    ", DefaultPicUrl='" + DefaultPicUrl + '\'' +
                    ", GameScore='" + GameScore + '\'' +
                    ", GameLib='" + GameLib + '\'' +
                    ", TitleIntact='" + TitleIntact + '\'' +
                    ", NodeId=" + NodeId +
                    ", editor='" + editor + '\'' +
                    ", AudioUrl='" + AudioUrl + '\'' +
                    ", Content_Index='" + Content_Index + '\'' +
                    '}';
        }
    }
}
