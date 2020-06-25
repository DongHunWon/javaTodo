function saveDate(data) {
    fetch(`./todo/save`, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            todo_content: data,
            isdone: 0
        })
    }).then(res => res.json());
    window.location.reload();
}

async function loadData() {
    let datalist = await fetch(`./todo/data/list`, {
        method: "get",
    }).then(res => res.json());

    datalist = datalist.map((data) =>
        `<li data-index="${data.id}">
            <button class="delete">×</button>
            <input type="checkbox" class="toggle-checked" ${data.isdone ? 'checked' : ''}/>
            <span class="text">${data.todo_content}</span>
         </li>`
    ).join('');

    return datalist;
}

async function deleteData(id) {
    await fetch(`./todo/data/delete/${parseInt(id.index)}`, {
        method: "delete",
    }).then(res => res.json());
    window.location.reload();
}

export {saveDate, loadData, deleteData};
