/*
 * Copyright 2017 Keval Patel.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.unittestdemo.base;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by Keval Patel on 04/03/17.
 * This base class is to extend the functionality of {@link AppCompatEditText}. Use this class instead
 * of {@link android.widget.EditText} through out the application.
 *
 * @author 'https://github.com/kevalpatel2106'
 */

@SuppressWarnings("unused")
public final class BaseEditText extends AppCompatEditText {
    public BaseEditText(Context context) {
        super(context);
        init(context);
    }

    public BaseEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //set type face
        AssetManager am = context.getApplicationContext().getAssets();
    }

    /**
     * Check if the edit text is empty.
     *
     * @return True uf there is no text entered in edit text.
     */
    public boolean isEmpty() {
        return getTrimmedText().isEmpty();
    }

    @Override
    public void setError(CharSequence error) {
        requestFocus();
        super.setError(error);
    }

    /**
     * @return Trimmed text.
     */
    @NonNull
    public String getTrimmedText() {
        return getText().toString().trim();
    }
}
