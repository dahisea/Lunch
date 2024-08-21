package com.dudu.wearlauncher.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import com.dudu.wearlauncher.R;
import com.dudu.wearlauncher.model.FastSettingsItem;
import com.dudu.wearlauncher.utils.ILog;
import com.google.android.material.internal.CheckableImageButton;
import org.jetbrains.annotations.NotNull;

public class SwitchIconButton extends CheckableImageButton {
    FastSettingsItem item;
    public SwitchIconButton(@NonNull @NotNull Context context) {
        this(context, null);
    }

    public SwitchIconButton(
            @NonNull @NotNull Context context,
            @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchIconButton(
            @NonNull @NotNull Context context,
            @Nullable @org.jetbrains.annotations.Nullable AttributeSet attrs,
            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setActivated(false);
        setForeground(getResources().getDrawable(R.drawable.ripple_effect));
        setBackground(getResources().getDrawable(R.drawable.circle_bg_gray));
        setOnClickListener(v->{ILog.e("aaaaa");});
        /*setOnTouchListener(
                (view, motionEvent) -> {
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        callOnClick();
                        setActivated(!isActivated());
                    }
                    return false;
                });*/
        setScaleType(ScaleType.CENTER);
    }

    public void attach(FastSettingsItem item) {
        item.button = this;
        if (item.action == FastSettingsItem.ItemAction.ACTION_METHOD_CLICK) {
            setOnClickListener(
                    v -> {
                        item.touchListener.onClick(isActivated());
                        setActivated(!isActivated());
                    });
            setOnLongClickListener(
                    v -> {
                        item.touchListener.onLongClick(isActivated());
                        return false;
                    });
            
        }
        if(item.action == FastSettingsItem.ItemAction.ACTION_OPEN_ACTIVITY) {
        	Intent intent = new Intent();
            intent.setClassName(item.targetPackage,item.targetActivity);
            getContext().startActivity(intent);
        }
        if (item.drawable != null) {
            setImageDrawable(item.drawable);
        }
        item.registerStateObserver(getContext());
    }
    
}
