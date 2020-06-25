import { saveData, loadData, deleteData, updateData } from './data-manager.js';

const $result = document.querySelector('#result');
const $input_form = document.querySelector('#input-form');
const $input = document.querySelector('#input');

let todos;

async function init() {
    todos = await loadData();
    $result.innerHTML = todos;
}

$input_form.addEventListener("submit", (event) => {
    event.preventDefault();
    const value = $input.value;
    if(!value.trim()) return;
    $input.value = '';

    saveData(value);
});

$result.addEventListener('click',event => {
    const target = event.target;
    if(target.className === 'delete') {
        deleteData(target.parentElement.dataset.index);
    }
    else if(target.className === 'toggle-checked') {
        updateData(target.parentElement.dataset.index, target.nextElementSibling.innerHTML, Number(target.checked));
    }
});

init();