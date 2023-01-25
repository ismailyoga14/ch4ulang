// Generated by view binder compiler. Do not edit!
package com.challenge.ulangch4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.challenge.ulangch4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWelcomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final ImageView ivLawanCom;

  @NonNull
  public final AppCompatImageView ivLawanPemain;

  @NonNull
  public final TextView tvLawanCom;

  @NonNull
  public final TextView tvLawanPemain;

  @NonNull
  public final TextView tvWelcome;

  private ActivityWelcomeBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull ImageView ivLawanCom, @NonNull AppCompatImageView ivLawanPemain,
      @NonNull TextView tvLawanCom, @NonNull TextView tvLawanPemain, @NonNull TextView tvWelcome) {
    this.rootView = rootView;
    this.ivLawanCom = ivLawanCom;
    this.ivLawanPemain = ivLawanPemain;
    this.tvLawanCom = tvLawanCom;
    this.tvLawanPemain = tvLawanPemain;
    this.tvWelcome = tvWelcome;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_welcome, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWelcomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_lawan_com;
      ImageView ivLawanCom = ViewBindings.findChildViewById(rootView, id);
      if (ivLawanCom == null) {
        break missingId;
      }

      id = R.id.iv_lawan_pemain;
      AppCompatImageView ivLawanPemain = ViewBindings.findChildViewById(rootView, id);
      if (ivLawanPemain == null) {
        break missingId;
      }

      id = R.id.tv_lawan_com;
      TextView tvLawanCom = ViewBindings.findChildViewById(rootView, id);
      if (tvLawanCom == null) {
        break missingId;
      }

      id = R.id.tv_lawan_pemain;
      TextView tvLawanPemain = ViewBindings.findChildViewById(rootView, id);
      if (tvLawanPemain == null) {
        break missingId;
      }

      id = R.id.tv_welcome;
      TextView tvWelcome = ViewBindings.findChildViewById(rootView, id);
      if (tvWelcome == null) {
        break missingId;
      }

      return new ActivityWelcomeBinding((LinearLayoutCompat) rootView, ivLawanCom, ivLawanPemain,
          tvLawanCom, tvLawanPemain, tvWelcome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
