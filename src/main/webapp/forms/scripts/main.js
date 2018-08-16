function handleSubmit(e) {
  var name = document.getElementById('name').value;
  var url =
    'http://localhost:8080/engine-rest/process-instance?businessKey=' + name;

  fetch(url).then(function(data) {
    console.log(data);
  });

  return false;
}
