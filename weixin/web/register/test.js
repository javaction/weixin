function funSave() {
  var username = $('#testText1')[0].value;
  var password = $('#testText2')[0].value;
  var str = '{mydata:[' + '{username:' + username + ',password:' + password + '}' + ']}';

  str = "{MyData:[{username:'" + username + "',password:'" + password + "'}]}";

//var json = eval('(' + str + ')');

  var fso, tf;
  try{
    fso = new ActiveXObject("Scripting.FileSystemObject");
    tf = fso.CreateTextFile("sucess.json", true);
    tf.WriteLine(str);
  }catch(err){


  }finally{
    tf.Close();
  }
}

function funSearch() {
  var fso, ts, s;
  var ForReading = 1;
  try{
    fso = new ActiveXObject("Scripting.FileSystemObject");
    ts = fso.OpenTextFile("sucess.json", ForReading);
    s = ts.ReadLine();
    var json = eval('(' + s + ')');
    alert(json.MyData[0].username);
  }catch(err){


  }finally{
    ts.Close();
  }
}
