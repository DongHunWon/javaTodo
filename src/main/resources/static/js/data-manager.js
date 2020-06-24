function saveDate(data) {
    fetch(`./todo/save`, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            todo_content: data
        })
    }).then(res => res.json());
    window.location.reload();
}

async function loadData() {
    let datalist = await fetch(`./todo/data/list`, {
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

export {saveDate, loadData};
