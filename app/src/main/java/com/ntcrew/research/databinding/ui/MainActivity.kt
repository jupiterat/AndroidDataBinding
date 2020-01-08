/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ntcrew.research.databinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ntcrew.research.databinding.R
import com.ntcrew.research.databinding.data.SimpleViewModel
import com.ntcrew.research.databinding.databinding.MainPlainActivityBinding

/**
 * Plain old activity with lots of problems to fix.
 */
class MainActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file, converting it to Pascal case and adding the Binding suffix to it.
        var binding : MainPlainActivityBinding = DataBindingUtil.setContentView(this,
            R.layout.main_plain_activity
        )

        //LiveData is a lifecycle-aware observable so you need to specify what lifecycle owner to use. You do this in the binding object.
        binding.lifecycleOwner = this

        binding.viewmodel = viewModel
    }
}
