package com.example.agerectifier.view.components.typebar


import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.agerectifier.R
import com.example.agerectifier.viewmodel.ViewModel

@Composable
fun TypeBar(
    viewModel: ViewModel = hiltViewModel()
){
    var selectedType by remember { mutableStateOf("Month") }
    viewModel.userDataCollector.value.type = selectedType
    var offsetValue by remember { mutableStateOf(0.dp) }
    val offsetSelectionCircleTransition by animateDpAsState(
        offsetValue,
        animationSpec = spring(Spring.DampingRatioMediumBouncy,Spring.StiffnessLow)
    )

    Column{
        Surface(
            color = colorResource(id = R.color.teal_project),
            shape = RoundedCornerShape(40.dp),
            modifier = Modifier
                .height(60.dp)
                .width(320.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Spacer(Modifier.absolutePadding(left = 8.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.width(60.dp)
                ){
                    SelectionCircle(offsetSelectionCircleTransition)
                    Types(name = "Month", isSelected = selectedType=="Month",
                        modifier = Modifier.clickable {
                            selectedType = "Month"
                            offsetValue = offsetValue(selectedType)

                        })
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.width(60.dp)
                ){
                    Types(name = "Day", isSelected = selectedType=="Day",
                        modifier = Modifier.clickable {
                            selectedType = "Day"
                            offsetValue = offsetValue(selectedType)
                        })
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.width(60.dp)
                ){
                    Types(name = "Hour", isSelected = selectedType=="Hour",
                        modifier = Modifier.clickable {
                            selectedType = "Hour"
                            offsetValue = offsetValue(selectedType)
                        })
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.width(60.dp)
                ){
                    Types(name = "Min", isSelected = selectedType=="Min",
                        modifier = Modifier.clickable {
                            selectedType = "Min"
                            offsetValue = offsetValue(selectedType)
                        })
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.width(60.dp)
                ){
                    Types(name = "Sec", isSelected = selectedType=="Sec",
                        modifier = Modifier.clickable {
                            selectedType = "Sec"
                            offsetValue = offsetValue(selectedType)
                        })
                }
                Spacer(Modifier.absolutePadding(right = 8.dp))
            }
        }
    }
}