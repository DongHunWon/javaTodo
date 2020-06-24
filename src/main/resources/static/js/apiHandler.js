// let id = getParameter('id');
// fetch(`./todo/1`, {
//     method: "get",
// })
//     .then(res => res.json())
//     .then(data => {
//         let item = `<h1>${data.todo_content}</h1><input type="checkbox" ${data.isdone ? 'checked' : ''}>`;
//         document.getElementById('result').innerHTML = item;
//     })

let item = '';
fetch(`./todo/`, {
    method: "get",
})
    .then(res => res.json())
    .then(datas => {
        datas.map((data) => {
            item += `<h1>${data.todo_content}</h1><input type="checkbox" ${data.isdone ? 'checked' : ''}>`;
        });
        document.getElementById('result').innerHTML = item;
    });