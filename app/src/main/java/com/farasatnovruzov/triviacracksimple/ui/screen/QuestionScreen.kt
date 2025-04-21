package com.farasatnovruzov.triviacracksimple.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farasatnovruzov.triviacracksimple.data.model.QuestionItem
import com.farasatnovruzov.triviacracksimple.ui.viewmodel.QuestionViewModel
import com.farasatnovruzov.triviacracksimple.util.Resource

@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    selectedCategory: String,
    questionViewModel: QuestionViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = selectedCategory) {
        questionViewModel.getAllQuestions(selectedCategory)
    }
    val state = questionViewModel.questionState.value
    val questionIndex = remember { mutableIntStateOf(0) }
    when(state){
        is Resource.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.size(100.dp),
                    color = Color.Cyan,
                    strokeWidth = 10.dp,
                    strokeCap = StrokeCap.Round
                )
            }
        }
        is Resource.Error -> {
            Log.e("QuestionScreen", "QuestionScreen Error: ${state.message}")
        }
        is Resource.Success -> {
            val question = try{
                state.data?.get(questionIndex.intValue)
            }catch (e: Exception){
                Log.e("QuestionScreen", "QuestionScreen Error: ${e.message}")
            }
            if(state.data != null && question != null){
                if(question is QuestionItem){
                    QuestionLayout(
                        question = question,
                        questionIndex = questionIndex,
                        viewModel = questionViewModel,
                        onNextClicked = {
                            questionIndex.intValue ++
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun QuestionLayout(
    question: QuestionItem?,
    questionIndex: MutableIntState,
    viewModel: QuestionViewModel,
    onNextClicked: (Int) -> Unit,
){
    var totalQuestion by remember { mutableIntStateOf(0) }
    LaunchedEffect(
//        key1 = questionIndex.intValue
        key1 = true
    ) {
        totalQuestion = viewModel.getTotalQuestionsCount()
    }

    val questionChoicesState = remember(question) { question?.choices?.toMutableList()?: emptyList()  }
    val userAnswerState = remember(question) { mutableStateOf<Int?>(null) }
    val userCorrectAnswerCountState = remember { mutableIntStateOf(0) }
    val userWrongAnswerCountState = remember { mutableIntStateOf(0) }
    val correctAnswerState = remember(question) { mutableStateOf<Boolean>(false) }
    val answerAction: (Int) -> Unit = remember(question) {
        {
            userAnswerState.value = it
            correctAnswerState.value = questionChoicesState[it] == question?.answer

            if (correctAnswerState.value == true) {
                userCorrectAnswerCountState.intValue +=1
            }else{
                userWrongAnswerCountState.intValue +=1
            }
        }
    }

    val isNextButtonPassive = remember(question) { mutableStateOf(false)}
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        color = Color.DarkGray
    ){
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            Spacer(modifier = Modifier.height(20.dp))
            ScoreBar(
                userCorrectAnswerCountState.intValue,
                userWrongAnswerCountState.intValue
            )
            QuestionTrackerBar(
                counter = questionIndex.intValue,
                outOf = totalQuestion
            )
            DrawDottedLine()
            Column {
                Text(
                   text = question?.question ?: "Question",
                    modifier = Modifier.padding(5.dp)
                        .align(Alignment.Start),
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 23.sp,
                )
                Spacer(modifier = Modifier.height(70.dp))
                QuestionChoicesLayout(
                    questionChoicesState = questionChoicesState,
                    userAnswerState = userAnswerState,
                    answerAction = answerAction,
                    isNextButtonPassive = isNextButtonPassive,
                    correctAnswerState = correctAnswerState
                )
                Spacer(modifier = Modifier.height(100.dp))
                IconButton(
                    onClick = {
                        onNextClicked.invoke(questionIndex.intValue)
//                        userAnswerState.value = null
//                        isNextButtonPassive.value = true
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .border(2.dp,Color.Red, RoundedCornerShape(30.dp))
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.Cyan),
                    enabled = isNextButtonPassive.value
                ) {
                    Icon(
                        modifier = Modifier
                            .size(50.dp),
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Next Button",
                        tint = Color.White
                    )
                }

            }
        }
    }

}