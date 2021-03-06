package com.compscieddy.meetinthemiddle.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.compscieddy.meetinthemiddle.FontCache;
import com.compscieddy.meetinthemiddle.R;

public class FontEditText extends EditText {

  public FontEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    if (isInEditMode()) return;

    TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontEditText);
    int typefaceId = ta.getInt(R.styleable.FontEditText_fontface, FontCache.MONTSERRAT_REGULAR);
    int color = ta.getInt(R.styleable.FontEditText_color, -1);
    ta.recycle();

    if (color != -1) {
      setAllColors(color);
    }
    setTypeface(FontCache.get(context, typefaceId));
  }

  public void setAlphaHighlightColor(int color) {
    this.setHighlightColor(setAlpha(color, 0.4f));
  }

  private int setAlpha(int color, float alphaPercentage) {
    return Color.argb(
        Math.round(Color.alpha(color) * alphaPercentage),
        Color.red(color),
        Color.green(color),
        Color.blue(color));
  }

  public void setAllColors(int color) {
    if (!(this.getBackground() instanceof GradientDrawable)) {
      Log.e("UFUCKEDUP", "Background is not a custom drawable!!! -Recheck your code");
    }
    this.setTextColor(color);
    setHintTextColor(color);

  }

}
