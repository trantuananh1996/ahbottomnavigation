package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.appcompat.content.res.AppCompatResources;
import android.view.View;

/**
 * AHBottomNavigationItem
 * The item is display in the AHBottomNavigation layout
 */
public class AHBottomNavigationItem {

    private String title = "";
    private Drawable drawable;
    private int color = Color.GRAY;

    private
    @StringRes
    int titleRes = 0;
    private
    @DrawableRes
    int drawableRes = 0;
    @DrawableRes
    int activeDrawableRes = 0;
    private
    @ColorRes
    int colorRes = 0;

    private boolean isCustomView = false;

    private @LayoutRes
    int customLayoutId;
    private OnBindCustomItemView onBindCustomItemView;
    private Object data;

    public int getCustomLayoutId() {
        return customLayoutId;
    }

    public OnBindCustomItemView getOnBindCustomItemView() {
        return onBindCustomItemView;
    }

    public boolean isCustomView() {
        return isCustomView;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public interface OnBindCustomItemView {
        void onBindView(View view, Object data);
    }

    /**
     * Constructor
     *
     * @param title    Title
     * @param resource Drawable resource
     */
    public AHBottomNavigationItem(String title, @DrawableRes int resource) {
        this.title = title;
        this.drawableRes = resource;
    }

    /**
     * Constructor
     *
     * @param title    Title
     * @param resource Drawable resource
     */
    public AHBottomNavigationItem(@StringRes int title, @DrawableRes int resource) {
        this.titleRes = title;
        this.drawableRes = resource;
    }


    public AHBottomNavigationItem(@LayoutRes int resId, OnBindCustomItemView onBindCustomItemView) {
        this.customLayoutId = resId;
        this.onBindCustomItemView = onBindCustomItemView;
        this.isCustomView = true;
    }

    /**
     * @param title    Title
     * @param resource Drawable resource
     * @param color    Background color
     */
    @Deprecated
    public AHBottomNavigationItem(String title, @DrawableRes int resource, @ColorRes int color) {
        this.title = title;
        this.drawableRes = resource;
        this.color = color;
    }

    /**
     * Constructor
     *
     * @param titleRes    String resource
     * @param drawableRes Drawable resource
     * @param colorRes    Color resource
     */
    public AHBottomNavigationItem(@StringRes int titleRes, @DrawableRes int drawableRes, @ColorRes int colorRes) {
        this.titleRes = titleRes;
        this.drawableRes = drawableRes;
        this.colorRes = colorRes;
    }

    /**
     * Constructor
     *
     * @param title    String
     * @param drawable Drawable
     */
    public AHBottomNavigationItem(String title, Drawable drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    /**
     * Constructor
     *
     * @param title    String
     * @param drawable Drawable
     * @param color    Color
     */
    public AHBottomNavigationItem(String title, Drawable drawable, @ColorInt int color) {
        this.title = title;
        this.drawable = drawable;
        this.color = color;
    }

    public String getTitle(Context context) {
        if (titleRes != 0) {
            return context.getString(titleRes);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleRes = 0;
    }

    public void setTitle(@StringRes int titleRes) {
        this.titleRes = titleRes;
        this.title = "";
    }

    public int getColor(Context context) {
        if (colorRes != 0) {
            return ContextCompat.getColor(context, colorRes);
        }
        return color;
    }

    public void setColor(@ColorInt int color) {
        this.color = color;
        this.colorRes = 0;
    }

    public void setColorRes(@ColorRes int colorRes) {
        this.colorRes = colorRes;
        this.color = 0;
    }

    @Nullable
    public Drawable getDrawable(Context context) {
        if (drawableRes != 0) {
            try {
                return AppCompatResources.getDrawable(context, drawableRes);
            } catch (Resources.NotFoundException e) {
                return AppCompatResources.getDrawable(context, drawableRes);
            }
        }
        return drawable;
    }

    @Nullable
    public Drawable getDrawable(Context context, boolean active) {
        if (active) return getActiveDrawable(context);
        else return getDrawable(context);
    }

    public void setDrawable(@DrawableRes int drawableRes) {
        this.drawableRes = drawableRes;
        this.drawable = null;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.drawableRes = 0;
    }

    public int getActiveDrawable() {
        return activeDrawableRes;
    }

    @Nullable
    public Drawable getActiveDrawable(Context context) {
        if (activeDrawableRes != 0) {
            try {
                return AppCompatResources.getDrawable(context, activeDrawableRes);
            } catch (Resources.NotFoundException e) {
                return AppCompatResources.getDrawable(context, activeDrawableRes);
            }
        }
        return null;
    }

    public void setActiveDrawableRes(int activeDrawableRes) {
        this.activeDrawableRes = activeDrawableRes;
    }
}
