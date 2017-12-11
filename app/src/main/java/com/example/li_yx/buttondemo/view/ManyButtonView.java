package com.example.li_yx.buttondemo.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.li_yx.buttondemo.ButtonModel;
import com.example.li_yx.buttondemo.R;

import java.util.ArrayList;

/**
 * Created by li_yx on 2017/12/11.
 */

public class ManyButtonView extends LinearLayout{

    //------------------------------- 声明 --------------------------------------
    public static final int FINISH = 0;// 完成态-----以成交
    public static final int WARNING = 1;// 警示态-----暂缓出票
    public static final int MIDDLE = 2;// 中间态-----处理中

    //------------------------------ 成员 ----------------------------------------
    private LinearLayout orderOperationView;
    private View ctsOrderOperationStatusView;
    private ImageView ctsOrderOperationStatusPicIv;
    private TextView ctsOrderOperationStatusNameTv;
    private View order_info_view;


    public ManyButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_status_view, null);

        order_info_view = view.findViewById(R.id.order_info_view);

        //订单状态
        ctsOrderOperationStatusView = view.findViewById(R.id.ctsOrderOperationStatusView);
        ctsOrderOperationStatusPicIv = (ImageView) view.findViewById(R.id.ctsOrderOperationStatusPicIv);
        ctsOrderOperationStatusNameTv = (TextView) view.findViewById(R.id.ctsOrderOperationStatusNameTv);

        orderOperationView = view.findViewById(R.id.ctsOrderOperationView);

        addView(view);
    }



    public void configStatus(int orderStatusStyle, String orderStatusName, ArrayList<ButtonModel> operationList) {

        if (TextUtils.isEmpty(orderStatusName) && operationList.size() == 0) {
            order_info_view.setVisibility(GONE);
        } else {
            order_info_view.setVisibility(VISIBLE);

            initStatusView(orderStatusName, orderStatusStyle);

            for (final ButtonModel buttonModel : operationList) {
                final CustomButton customButton = new CustomButton(getContext());
                final View iv = customButton.findViewById(R.id.ctsRedPointIv);
                customButton.configButton(buttonModel);
                orderOperationView.addView(customButton);
                customButton.setOnClickListener(buttonModel.listener);
            }

        }
    }


    private void initStatusView(String orderStatusName, int orderStatusStyle) {

        if (TextUtils.isEmpty(orderStatusName)) {
            ctsOrderOperationStatusView.setVisibility(GONE);

        } else {
            ctsOrderOperationStatusView.setVisibility(VISIBLE);
            ctsOrderOperationStatusNameTv.setText(orderStatusName);

            switch (orderStatusStyle) {
                case FINISH: {
                    ctsOrderOperationStatusPicIv.setImageResource(R.drawable.cts_order_statue_normal);
                    ctsOrderOperationStatusNameTv.setTextColor(Color.parseColor("#666666"));
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.cts_arrow_right_two);
                    drawable.setBounds(0, 0, 26, 26);
                    ctsOrderOperationStatusNameTv.setCompoundDrawables(null, null, drawable, null);
                    break;
                }
                case WARNING: {
                    ctsOrderOperationStatusPicIv.setImageResource(R.drawable.cts_order_statue_warning);
                    ctsOrderOperationStatusNameTv.setTextColor(Color.parseColor("#ED494B"));
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.cts_red_arrow_right);
                    drawable.setBounds(0, 0, 26, 26);
                    ctsOrderOperationStatusNameTv.setCompoundDrawables(null, null, drawable, null);
                    break;
                }
                case MIDDLE: {
                    ctsOrderOperationStatusPicIv.setImageResource(R.drawable.cts_order_statuee_waiting);
                    ctsOrderOperationStatusNameTv.setTextColor(Color.parseColor("#666666"));
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.cts_arrow_right_two);
                    drawable.setBounds(0, 0, 26, 26);
                    ctsOrderOperationStatusNameTv.setCompoundDrawables(null, null, drawable, null);
                    break;
                }
                default:
                    break;
            }

            ctsOrderOperationStatusView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view){
                    Toast.makeText(getContext(),"状态",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
