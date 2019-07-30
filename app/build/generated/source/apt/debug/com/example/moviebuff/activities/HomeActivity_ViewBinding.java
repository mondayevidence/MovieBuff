// Generated code from Butter Knife. Do not modify!
package com.example.moviebuff.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.moviebuff.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target, View source) {
    this.target = target;

    target.sliderpager = Utils.findRequiredViewAsType(source, R.id.slider_pager, "field 'sliderpager'", ViewPager.class);
    target.indicator = Utils.findRequiredViewAsType(source, R.id.indicator, "field 'indicator'", TabLayout.class);
    target.MoviesRV = Utils.findRequiredViewAsType(source, R.id.Rv_movies, "field 'MoviesRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sliderpager = null;
    target.indicator = null;
    target.MoviesRV = null;
  }
}
