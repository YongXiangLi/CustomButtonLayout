package com.example.li_yx.buttondemo.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.li_yx.buttondemo.ButtonModel;
import com.example.li_yx.buttondemo.R;


public class CustomButton extends RelativeLayout{

    private final TextView cts_promotion;
    private final View layout;
    private final TextView button;
    private final ImageView iv;


    public CustomButton(Context context) {
        super(context);

        View view = LayoutInflater.from(context).inflate(R.layout.custom_button_view, this, true);
        cts_promotion = (TextView) view.findViewById(R.id.ctsPromotion);
        layout = view.findViewById(R.id.ctsButtonLayput);
        button = view.findViewById(R.id.ctsOperationBtn);
        iv = view.findViewById(R.id.ctsRedPointIv);

    }

    public void configButton(final ButtonModel model) {

        if (!TextUtils.isEmpty(model.textContent)) {

            layout.setVisibility(VISIBLE);

            if (TextUtils.isEmpty(model.promotion)) {
                cts_promotion.setVisibility(GONE);
            } else {
                cts_promotion.setVisibility(VISIBLE);
                cts_promotion.setText(model.promotion);
            }
            button.setText(model.textContent);
            if (model.isShowRedPoint) {
                iv.setVisibility(VISIBLE);
            } else {
                iv.setVisibility(INVISIBLE);
            }


        } else {
            layout.setVisibility(GONE);
        }

    }

}
