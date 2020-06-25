async function saveData(data) {
    await fetch(`./todo/save`, {
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
    let datalist = await fetch(`./todo/list`, {
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
    await fetch(`./todo/delete/${parseInt(id)}`, {
        method: "delete",
    }).then(res => res.json());
    window.location.reload();
}

async function updateData(id, data, isdone) {
    await fetch(`./todo/update`, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            id: id,
            todo_content: data,
            isdone: isdone
        })
    }).then(res => res.json());
}



export {saveData, loadData, deleteData, updateData};
