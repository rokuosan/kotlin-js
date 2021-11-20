import kotlinx.browser.document
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.get

fun main() {
    val number1 = document.getElementById("number1") as HTMLInputElement
    val number2 = document.getElementById("number2") as HTMLInputElement
    // 足し算
    val add = document.getElementById("add") as HTMLButtonElement
    val addResult = document.getElementById("result-add") as HTMLInputElement
    // 引き算
    val subtractResult = document.getElementById("result-subtract") as HTMLInputElement
    // 掛け算
    val multiplyResult = document.getElementById("result-multiply") as HTMLInputElement
    // 割り算
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