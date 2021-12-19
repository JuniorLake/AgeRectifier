package com.example.agerectifier.view.components.typebar

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.agerectifier.R

@Composable
fun SelectionCircle(offset: Dp? = null){
    Surface(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .requiredWidth(60.dp)
            .requiredHeight(40.dp)
            .offset(offset!!),
        color = colorResource(R.color.white_project)
    ) {

    }
}