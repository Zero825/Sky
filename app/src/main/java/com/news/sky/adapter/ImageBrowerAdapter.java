package com.news.sky.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.github.piasy.biv.indicator.ProgressIndicator;
import com.github.piasy.biv.utils.IOUtils;
import com.github.piasy.biv.view.BigImageView;
import com.github.piasy.biv.view.GlideImageViewFactory;
import com.news.sky.R;
import com.news.sky.commentpart.ImageInfe;
import com.news.sky.databinding.ItemBigImageBinding;
import com.news.sky.util.SnackbarUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageBrowerAdapter extends ListAdapter<ImageInfe, ImageBrowerAdapter.ImageBorwerViewHolder> {

    public ImageBrowerAdapter() {
        super(new DiffUtil.ItemCallback<ImageInfe>() {
            @Override
            public boolean areItemsTheSame(@NonNull ImageInfe oldItem, @NonNull ImageInfe newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull ImageInfe oldItem, @NonNull ImageInfe newItem) {
                return false;
            }
        });
    }

    @NonNull
    @Override
    public ImageBorwerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBigImageBinding binding = ItemBigImageBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ImageBorwerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageBorwerViewHolder holder, int position) {
        holder.binding.bigImageView.showImage(Uri.parse(getItem(position).getOrigin()));
    }

    public static class ImageBorwerViewHolder extends RecyclerView.ViewHolder {
        ItemBigImageBinding binding;


        public ImageBorwerViewHolder(@NonNull ItemBigImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            init();
        }

        private void init() {
            binding.bigImageView.setImageViewFactory(new GlideImageViewFactory());
            binding.bigImageView.setProgressIndicator(new ProgressIndicator() {
                @Override
                public View getView(BigImageView parent) {
                    return null;
                }

                @Override
                public void onStart() {
                    binding.indicator.show();
                }

                @Override
                public void onProgress(int progress) {
                    binding.indicator.setProgressCompat(progress, true);
                }

                @Override
                public void onFinish() {
                    binding.indicator.hide();
                }
            });
            binding.bigImageView.setOnClickListener(view -> ((Activity) view.getContext()).finish());
            binding.bigImageView.setOnLongClickListener(view -> {
                if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) view.getContext(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                    return false;
                }
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                    return false;
                }
                if (saveImage(view.getContext(), binding.bigImageView.getCurrentImageFile())) {
                    SnackbarUtils.showShortSnackbar(view, view.getContext().getResources().getString(R.string.image_save_success));
                } else {
                    SnackbarUtils.showShortSnackbar(view, view.getContext().getResources().getString(R.string.image_save_fail));
                }
                return true;
            });
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean saveImage(Context context, File file) {
        OutputStream outputStream = null;
        FileInputStream inputStream = null;
        Uri imageUri;
        boolean isSave;
        try {
            ContentResolver resolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,
                    file.getName());
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/png");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES);
            imageUri =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

            if (imageUri != null) {
                outputStream = resolver.openOutputStream(imageUri);
                inputStream = new FileInputStream(file);
                IOUtils.copy(inputStream, outputStream);
            }
            isSave = true;
        } catch (IOException e) {
            isSave = false;
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
        return isSave;
    }
}
