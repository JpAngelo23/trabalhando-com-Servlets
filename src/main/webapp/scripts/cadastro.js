const selectTipoConta = document.getElementById("tipo_conta");

selectTipoConta.addEventListener("change", (event) => {
  if(event.target.value === "pf") {
    document.getElementById("pessoa_fisica").style.display = "flex";
    document.getElementById("pessoa_juridica").style.display = "none";
  } else {
    document.getElementById("pessoa_fisica").style.display = "none";
    document.getElementById("pessoa_juridica").style.display = "flex";
  }
})