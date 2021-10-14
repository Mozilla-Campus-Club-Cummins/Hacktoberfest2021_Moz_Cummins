


  function sendmail(){
     var name=$("#Name").val();
    var email=$("#Email").val();
    var subject=$("#Subject").val();
    var query=$("#Query").val();
    var message=$("#Message").val();

    var Body="Name: "+name+ "<br>Email:"+email+ "<br>Subject: "+subject+"<br>Query: "+query+ " <br>Message:"+message;

    Email.send({
    SecureToken : "7fc99c57-d7e5-423e-a4b6-6c72a5c0f2f9",
    To : 'vishakhamanagoli@gmail.com',
    From : "freakmanagoli@gmail.com",
    Subject : "This is the subject",
    Body : Body
}).then(
  message => {
        if(message=='OK'){
           alert("Thank You, your mail has been sent successfully")
         }
        else{
           console.error(message);
           alert(message)
     }

}
);
}