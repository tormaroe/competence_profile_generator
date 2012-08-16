
window.document.cpg = (function () {
  var saveData = function(key, value, success) {
    $.post("/save-data", { key: key, value: value })
      .success(success)
      .error(function() { alert("error saving data"); });
  };

  return {
    updateData: function(key, inputField) {
                  saveData(key, document.getElementById(inputField).value, function() { });
                },
    addNewDataField: function() {
                       var key = prompt("Type in the new key (NO SPACES PLEASE)", ""),
                           value = prompt("And now type in the value", "");
                       saveData(key, value, function() {
                          document.location = "/manage-data";
                       });
                     },
    deleteData: function(key) {
                  if(confirm("ARE YOU SURE YOU WANT TO DELETE THIS KEY?\nIf it's is use this will mess up the profile generation..")) {
                    $.post("/delete-data", {key: key})
                      .success(function() {
                        document.location = "/manage-data";
                      })
                      .error(function() { alert("error deleting data"); });
                  }
                }
  };
})();
