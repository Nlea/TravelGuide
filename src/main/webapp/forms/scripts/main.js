function addToHtml(title, content) {
  //   <div>
  //     <div class="card">
  //       <h2>title</h2>
  //       <div id="robotURL">
  //         content
  //       </div>
  //     </div>
  // </div>
  var parent = document.getElementById('results');

  var divFirst = document.createElement('div');
  var divSecond = document.createElement('div');
  divSecond.className = 'card';
  divFirst.appendChild(divSecond);

  var div = document.createElement('div');
  div.className = 'child';
  var myheadLine = document.createElement('h2');
  myheadLine.innerHTML = title;
  div.innerHTML = content;

  divSecond.appendChild(myheadLine);
  divSecond.appendChild(div);

  parent.appendChild(divFirst);
}

function parseVaribles(variables) {
  var keys = Object.keys(variables);

  keys.map(function(key) {
    var content = variables[key].value;
    var html =
      content.toString().substring(0, 4) === 'http'
        ? `<img src=${content} />`
        : content;

    addToHtml(key, html);
  });
}

function fetchVariables(id) {
  var url =
    'http://localhost:8080/engine-rest/process-instance/' + id + '/variables';

  fetch(url)
    .then(function(response) {
      return response.json();
    })
    .then(function(myJson) {
      parseVaribles(myJson);
    });
}

function handleSubmit(e) {
  var name = document.getElementById('name').value;
  document.getElementById('form').style.display = 'none';
  document.getElementById('results').style.display = 'flex';

  var url =
    'http://localhost:8080/engine-rest/process-instance?businessKey=' + name;

  fetch(url)
    .then(function(response) {
      return response.json();
    })
    .then(function(myJson) {
      var id = myJson[0].id;
      fetchVariables(id);
    });

  return false;
}
