package apidez.com.lab1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import apidez.com.lab1.R;
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
        ViewHolder viewHolder;

        // If we need to create a new view for the ListView item that must be displayed now
        if (convertView == null) {
            // Create a new ListView item view, create a new ViewHolder (generic), and add the
            // ViewHolder to this newly created view. In the future, this view can then be reused
            // together with its ViewHolder.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
            viewHolder = createNewViewHolder(convertView);
            convertView.setTag(viewHolder);
            Log.d("PostAdapter", "Creating a new list item view");
        }
        // If we can reuse an old ListView item view (convertView) for the item that must be
        // displayed now, get this view's ViewHolder
        else
            viewHolder = (ViewHolder) convertView.getTag();

        // Populate the elements of the ListView item through the references in the ViewHolder
        viewHolder.tvUsername.setText(post.getUsername());
        viewHolder.tvDescription.setText(post.getDescription());
        viewHolder.tvDate.setText(post.getDate());
        loadImage(viewHolder.ivImage, post.getImage());
        loadImage(viewHolder.ivAvatar, post.getAvatar());
        return convertView;
    }

    private ViewHolder createNewViewHolder(View convertView) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
        viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
        viewHolder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
        viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
        return viewHolder;
    }

    private void loadImage(ImageView imageView, String path) {
        Picasso.with(getContext()).load(path).placeholder(R.drawable.placeholder).into(imageView);
    }

    private static class ViewHolder {
        TextView tvUsername;
        TextView tvDescription;
        TextView tvDate;
        ImageView ivAvatar;
        ImageView ivImage;
    }
}
