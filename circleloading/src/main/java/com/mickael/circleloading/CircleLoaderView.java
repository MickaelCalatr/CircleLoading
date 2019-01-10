package com.mickael.circleloading;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CircleLoaderView extends FrameLayout {
    /**
     * This is the alpha applied to the background
     */
    private float maxAlpha;

    // UI ELEMENTS
    /**
     * This is the image loader (the rotating item).
     */
    private ImageView image;
    /**
     * This is the background behind the loader.
     */
    private View background;
    /**
     * This is a View used to translate the loader from the LEFT to the RIGHT.
     */
    private FrameLayout translator;

    // DURATIONS
    /**
     * This is the time (in ms) use to translate from the LEFT to the middle of the screen and to
     * translate from the middle of the screen to the RIGHT.
     */
    private int translateDuration;
    /**
     * This is the time (in ms) used to fade in and fade out the [background]
     */
    private int fadeInOutDuration;
    /**
     * This is the time (in ms) used to rotate the loader [image].
     */
    private int rotateDuration;

    // ANIMATIONS
    /**
     * This is the animation of the image loader.
     */
    private RotateAnimation rotate;


    public CircleLoaderView(@NonNull Context context) {
        super(context);
        initialise(context, null);
    }

    public CircleLoaderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialise(context, attrs);
    }

    public CircleLoaderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(context, attrs);
    }


    /**
     * This function is called to initialise the View. The function initialise the Image, the
     * background and the FrameLayout used to translate the loader from the LEFT to the RIGHT. This
     * function get the possible argument from the view.
     * @param context   This is the current context from the constructor.
     * @param attrs     This is the possible attributes to configure the size, duration or color of
     *                  he loader
     */
    private void initialise(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_loader, this, true);
        this.image = (ImageView) findViewById(R.id.image_view_loader);
        this.background = (View) findViewById(R.id.view_background);
        this.translator = (FrameLayout) findViewById(R.id.frame_layout_translator);

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleLoaderView);
            // Init of the loader image
            final int imageId = ta.getResourceId(R.styleable.CircleLoaderView_image_loader, R.drawable.bowling_ball_1);
            this.image.setBackgroundResource(imageId);
            // Init of the size of the loader
            this.image.getLayoutParams().width = ta.getDimensionPixelSize(R.styleable.CircleLoaderView_image_width, 100);
            this.image.getLayoutParams().height = ta.getDimensionPixelSize(R.styleable.CircleLoaderView_image_height, 100);
            // Init of the
            int colorId;
            try {
                colorId = ta.getColor(R.styleable.CircleLoaderView_background_font, 31843);
                this.background.setBackgroundResource(colorId);
            } catch (Exception ignored) {
                colorId = ta.getResourceId(R.styleable.CircleLoaderView_background_font, R.color.color_loader);
                this.background.setBackgroundResource(colorId);
            }
            // Init of the alpha for the background and the durations for the transitions
            this.maxAlpha = ta.getFloat(R.styleable.CircleLoaderView_background_alpha, 0.7f);
            this.rotateDuration = ta.getInt(R.styleable.CircleLoaderView_rotate_duration, 700);
            this.translateDuration = ta.getInt(R.styleable.CircleLoaderView_translate_duration, 900);
            this.fadeInOutDuration = ta.getInt(R.styleable.CircleLoaderView_fadeInOut_duration, 500);
            ta.recycle();
        }
        // Put the view before all the UI elements
        this.setTranslationZ(50);

        // Init of the animation (rotation)
        initialiseAnimations();

        // Set all the UI element visible
        this.translator.setVisibility(GONE);
        this.image.setVisibility(GONE);
        this.background.setVisibility(GONE);
    }

    /**
     * This function initialise the rotation animation of the image. The function set the rotation
     * direction, the duration, and set the animation count to INFINITE
     */
    private void initialiseAnimations() {
        this.rotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        this.rotate.setDuration(this.rotateDuration);
        this.rotate.setRepeatCount(Animation.INFINITE);
        this.rotate.setInterpolator(new LinearInterpolator());
    }

    /**
     * This function is call when the loading is started, the function translate the FrameLayout
     * [translator] from the LEFT of the screen to the middle of the screen.
     */
    private void translateFromLeft() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(this.translator, "translationX", 0f);
        animation.setDuration(this.translateDuration);
        animation.start();
    }

    /**
     * This function is call when the loading is stopped, the function translate the FrameLayout
     * [translator] from the middle of the screen to the RIGHT of the screen. When the animation is
     * finished set the visibility [image] and the [translator] to GONE and set the [translator] to
     * the initial position on the LEFT of the screen.
     */
    private void translateToRight() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(this.translator, "translationX", this.translator.getWidth());
        animation.setDuration(this.translateDuration);
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }
            @Override
            public void onAnimationEnd(Animator animation) {
                translator.setVisibility(GONE);
                translator.setTranslationX(-1500);
                image.setVisibility(GONE);
                image.setAnimation(null);
            }
            @Override
            public void onAnimationCancel(Animator animation) { }
            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
        animation.start();
    }

    /**
     * This function is called to start the fadeOut animation, at the end of the animation, the
     * background visibility is set to GONE
     */
    public void fadeOutAnimation() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(this.background, View.ALPHA, this.maxAlpha, 0);
        alphaAnimation.setDuration(this.fadeInOutDuration);
        alphaAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                background.setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        alphaAnimation.start();
    }

    /**
     * This function is called to start the fadeIn animation on the background
     */
    private void fadeInAnimation() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(this.background, View.ALPHA, 0, this.maxAlpha);
        alphaAnimation.setDuration(this.fadeInOutDuration);
        alphaAnimation.start();
    }

    /**
     * This function is called to start the animation, the function set the visibility of all UI
     * elements to VISIBLE, start the rotating animation, start the fadeIn animation and start the
     * translate animation.
     */
    public void startLoading() {
        if (this.image.getAnimation() == null) {
            this.translator.setVisibility(VISIBLE);
            this.image.setVisibility(VISIBLE);
            this.background.setVisibility(VISIBLE);
            this.image.setAnimation(this.rotate);
            fadeInAnimation();
            translateFromLeft();
        }
    }

    /**
     * This function is called to stop the animation, the function start the translation to the
     * RIGHT of the screen and start the fadeOut animation.
     */
    public void stopLoading() {
        if (this.image.getAnimation() != null) {
            translateToRight();
            fadeOutAnimation();
        }
    }
}
