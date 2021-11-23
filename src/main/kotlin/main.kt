import kotlinx.browser.document
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement

fun main() {
    // 分離してる計算機
    val number1 = document.getElementById("number1") as HTMLInputElement
    val number2 = document.getElementById("number2") as HTMLInputElement
    val add = document.getElementById("add") as HTMLButtonElement
    val addResult = document.getElementById("result-add") as HTMLInputElement
    val subtractResult = document.getElementById("result-subtract") as HTMLInputElement
    val multiplyResult = document.getElementById("result-multiply") as HTMLInputElement
    val divideResult = document.getElementById("result-divide") as HTMLInputElement

    add.addEventListener("click", {
        if(number1.value.isBlank() || number2.value.isBlank()){
            addResult.placeholder = "数値が入力されていません"
            subtractResult.placeholder = "数値が入力されていません"
            multiplyResult.placeholder = "数値が入力されていません"
            divideResult.placeholder = "数値が入力されていません"
        }else {
            addResult.value = "${number1.valueAsNumber + number2.valueAsNumber}"
            subtractResult.value = "${number1.valueAsNumber - number2.valueAsNumber}"
            multiplyResult.value = "${number1.valueAsNumber * number2.valueAsNumber}"
            divideResult.value = "${number1.valueAsNumber / number2.valueAsNumber}"
        }
    })

    // 演算子を選択する計算機
    val number3 = document.getElementById("number3") as HTMLInputElement
    val number4 = document.getElementById("number4") as HTMLInputElement
    val result = document.getElementById("result") as HTMLInputElement
    val calc = document.getElementById("calc") as HTMLButtonElement

    calc.addEventListener("click", {
        val operator = document.getElementById("operator") as HTMLSelectElement
        if(operator.selectedIndex == 0){
            result.value = ""
            result.placeholder = "演算子を入力してください"
        }else{
            if(!(number3.value.isBlank() || number4.value.isBlank())){
                when (operator.selectedIndex) {
                    1 -> result.value = "${number3.valueAsNumber + number4.valueAsNumber}"
                    2 -> result.value = "${number3.valueAsNumber - number4.valueAsNumber}"
                    3 -> result.value = "${number3.valueAsNumber * number4.valueAsNumber}"
                    4 -> result.value = "${number3.valueAsNumber / number4.valueAsNumber}"
                }
            }else{
                result.placeholder = "数値を入力してください"
            }
        }
    })
}