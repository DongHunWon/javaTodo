async function loadData() {
    let datalist = await fetch(`./todo/datalist`, {
        method: "get",
    }).then(res => res.json());

    datalist = datalist.map((data, index) =>
        `<li data-index="${index + 1}">
                <button class="delete">×</button>
                <input type="checkbox" class="toggle-checked" ${data.isdone ? 'checked' : ''}/>
                <span class="text">${data.todo_content}</span>
             </li>`
    ).join('');

    return datalist;
}

export {loadData};
