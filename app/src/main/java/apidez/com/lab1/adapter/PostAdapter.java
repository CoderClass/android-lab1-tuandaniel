package apidez.com.lab1.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import apidez.com.lab1.R;
import apidez.com.lab1.databinding.ItemPostBinding;
import apidez.com.lab1.model.Post;

/**
 * Created by nongdenchet on 10/9/16.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    private List<Post> mPosts;

    public PostAdapter(Context context, List<Post> posts) {
        super(context, 0, posts);
        mPosts = posts;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post post = getItem(position);
        ItemPostBinding binding;  // The binding object works in some way like a built-in ViewHolder

        // Inflate a new list item view, initialise the data binding object for this view, and save
        // the data binding object in the tag of this view.
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.item_post, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }
        // Retrieve the data binding object of this recycled view
        else
            binding = (ItemPostBinding) convertView.getTag();

        // Populate the elements of the item view through the data binding object of this view
        binding.tvUsername.setText(post.getUsername());
        binding.tvDescription.setText(post.getDescription());
        binding.tvDate.setText(post.getDate());
        loadImage(binding.ivImage, post.getImage());
        loadImage(binding.ivAvatar, post.getAvatar());

        return convertView;
    }

    private void loadImage(ImageView imageView, String path) {
        Picasso.with(getContext()).load(path).placeholder(R.drawable.placeholder).into(imageView);
    }
}
