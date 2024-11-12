package com.trim.exception.object.domain;

import com.trim.exception.object.general.GeneralException;
import com.trim.exception.payload.code.BaseCode;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseCode code) {
        super(code);
    }
}
