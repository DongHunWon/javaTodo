import { loadData } from './data-manager.js';

const $result = document.querySelector('#result');

async function init() {
    const todos = await loadData();
    $result.innerHTML = `<ul>${todos}</ul>`;
}

init();