// Generated by view binder compiler. Do not edit!
package com.challenge.ulangch4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.challenge.ulangch4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentIntroductionTwoBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout frContentTwo;

  @NonNull
  public final AppCompatTextView tvLandingpage2;

  private FragmentIntroductionTwoBinding(@NonNull FrameLayout rootView,
      @NonNull FrameLayout frContentTwo, @NonNull AppCompatTextView tvLandingpage2) {
    this.rootView = rootView;
    this.frContentTwo = frContentTwo;
    this.tvLandingpage2 = tvLandingpage2;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentIntroductionTwoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentIntroductionTwoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_introduction_two, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentIntroductionTwoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout frContentTwo = (FrameLayout) rootView;

      id = R.id.tv_landingpage2;
      AppCompatTextView tvLandingpage2 = ViewBindings.findChildViewById(rootView, id);
      if (tvLandingpage2 == null) {
        break missingId;
      }

      return new FragmentIntroductionTwoBinding((FrameLayout) rootView, frContentTwo,
          tvLandingpage2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
