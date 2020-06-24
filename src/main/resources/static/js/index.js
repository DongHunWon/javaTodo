import { saveDate, loadData } from './data-manager.js';

const $result = document.querySelector('#result');
const $input_form = document.querySelector('#input-form');
const $input = document.querySelector('#input');

async function init() {
    const todos = await loadData();
    $result.innerHTML = `<ul>${todos}</ul>`;
}

$input_form.addEventListener("submit", (event) => {
    event.preventDefault();
    const value = $input.value;
    if(!value.trim()) return;

    saveDate(value);
});

init();