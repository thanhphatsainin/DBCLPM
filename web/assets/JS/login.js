
// Đối tượng 'Validator'

function Validator(options) {

    // lấy element form validate
    var formElement = document.querySelector(options.form);
    if(formElement){
        // lặp qua các rules
        options.rules.forEach(rule => {
            var inputElement = formElement.querySelector(rule.selector);
            if(inputElement){

                // on blur
                inputElement.onblur = () => {
                   validate(inputElement,rule)
                }

                // nhập input
                inputElement.oninput = () => {
                    var errorElement = inputElement.parentElement.querySelector('.form-message');
                    errorElement.innerHTML = '';
                    inputElement.parentElement.classList.remove('invalid'); 
                }
            }
        });

        //submit
        formElement.onsubmit = (e) =>{
            e.preventDefault();

            var isFormValid = true;
            options.rules.forEach(rule => {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement,rule);
                if(!isValid){
                    isFormValid = false;
                }
            })
            // submit js
            if(isFormValid){
                if(typeof options.onSubmit === 'function') {

                    var Inputs = formElement.querySelectorAll('[name]');
                    var formValues = Array.from(Inputs).reduce((values,input) =>{
                        return (values[input.name] = input.value) && values
                    },{});
                    options.onSubmit(formValues);
                }
                else{
                    formElement.submit();
                }
            }
        }
    }
}

function validate(inputElement,rule) {
    var errorElement = inputElement.parentElement.querySelector('.form-message');
    var errorMessage =rule.test(inputElement.value);
    if(errorMessage){
         errorElement.innerHTML = errorMessage;
         inputElement.parentElement.classList.add('invalid');
    }
    else{
         errorElement.innerHTML = '';
         inputElement.parentElement.classList.remove('invalid');

    } var errorMessage =rule.test(inputElement.value);
    if(errorMessage){
         errorElement.innerHTML = errorMessage;
         inputElement.parentElement.classList.add('invalid');
    }
    else{
         errorElement.innerHTML = '';
         inputElement.parentElement.classList.remove('invalid');

    }

    return !errorMessage; // có lỗi return false
}


// Định nghĩa các rules
// Nguyên tắc chung
// 1. khi có lỗi => trả ra message lôĩ
// 2. khi không có lỗi trả về undefined

Validator.isRequired = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : 'Vui lòng nhập trường này!!!';
        }
    }
}   
