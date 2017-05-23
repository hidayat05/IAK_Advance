package com.maskipli.iak.views.browser;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public interface BrowserView {

    void setProgresHide(boolean hide);

    void setSwipe();

    SwipeRefreshLayout getSwipe();
}
