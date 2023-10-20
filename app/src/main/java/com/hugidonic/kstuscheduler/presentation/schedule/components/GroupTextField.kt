package com.hugidonic.kstuscheduler.presentation.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.presentation.shared.CustomTextField
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

@Composable
fun GroupTextField(
    modifier: Modifier = Modifier,
    group: String,
    editGroup: (String) -> Unit,
) {
    var isEditMode by remember {
        mutableStateOf(false)
    }
    var newGroup by remember {
        mutableStateOf(group)
    }

    val editIcon = if (isEditMode) Icons.Filled.Check else Icons.Default.Edit

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = "Группа: ",
            style = MaterialTheme.typography.headlineMedium
        )
        if (isEditMode) {
            CustomTextField(
                value = newGroup,
                onValueChange = {
                    if (it.length <= 10) {
                        newGroup = it
                    }
                },
                shape = RoundedCornerShape(0.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                ),
                textStyle = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                modifier = Modifier
                    .width(intrinsicSize = IntrinsicSize.Min)
                    .background(MaterialTheme.colorScheme.background)
            )
        } else {
            Text(
                text = group,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .width(intrinsicSize = IntrinsicSize.Min)
                    .padding(horizontal = 10.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(modifier = Modifier.clickable {
            //  Toggle editMode and editGroup on exit editMode
            isEditMode = if (isEditMode) {
                editGroup(newGroup)
                false
            } else {
                true
            }
        }) {
            Icon(imageVector = editIcon, contentDescription = "Edit group")
        }
    }
}


@Composable
private fun PreviewGroupTextField() {
    AppTheme {
        Surface(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            GroupTextField(
                group = "1211-22",
                editGroup = {},
            )
        }
    }
}

@Preview
@Composable
private fun PreviewGroupTextField_EditMode_true() {
    PreviewGroupTextField()
}


@Preview
@Composable
private fun PreviewGroupTextField_EditMode_false() {
    PreviewGroupTextField()
}