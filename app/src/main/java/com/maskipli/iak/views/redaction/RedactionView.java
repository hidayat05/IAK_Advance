package com.maskipli.iak.views.redaction;

import com.maskipli.iak.models.beans.Redaction;

/**
 * @author nurhidayat
 * @since 5/23/17.
 */

public interface RedactionView {

    String bundleData();

    void onLoadSuccess(Redaction result);

    void onLoadFailed(Throwable throwable);

    void intentInto(Class activity, String stringExtra);

}
