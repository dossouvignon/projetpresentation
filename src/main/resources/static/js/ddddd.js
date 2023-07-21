const openPopupBtn = document.getElementById("openPopup");
const closePopupBtn = document.getElementById("closePopup");
const popupContainer = document.getElementById("popupContainer");

openPopupBtn.addEventListener("click", function() {
  popupContainer.style.display = "block";
});

closePopupBtn.addEventListener("click", function() {
  popupContainer.style.display = "none";
});

const form = document.getElementById("myForm");

form.addEventListener("submit", function(event) {
  event.preventDefault(); // Empêche l'envoi du formulaire

  // Récupérer les valeurs des champs du formulaire
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const message = document.getElementById("message").value;

  // Effectuer des validations supplémentaires si nécessaire

  // Envoyer les données du formulaire à un serveur ou effectuer une autre action
  console.log("Nom :", name);
  console.log("Email :", email);
  console.log("Message :", message);

  // Réinitialiser le formulaire après l'envoi
  form.reset();
});

const toggleButton = document.querySelector(".toggle-button");
const navLinks = document.querySelector(".nav-links");

toggleButton.addEventListener("click", function() {
  navLinks.classList.toggle("active");
});


const sidebar = document.querySelector(".sidebarr");
const sidebarToggle = document.querySelector(".sidebar-toggle");

sidebarToggle.addEventListener("click", function() {
  sidebar.classList.toggle("active");
});


// Exemple pour ajouter une ligne au tableau de reporting
function addReportRow(date, sales, costs, profits) {
    var table = document.getElementById("reportTable").getElementsByTagName("tbody")[0];
    var newRow = table.insertRow(table.rows.length);
    
    var dateCell = newRow.insertCell(0);
    dateCell.innerHTML = date;
    
    var salesCell = newRow.insertCell(1);
    salesCell.innerHTML = sales;
    
    var costsCell = newRow.insertCell(2);
    costsCell.innerHTML = costs;
    
    var profitsCell = newRow.insertCell(3);
    profitsCell.innerHTML = profits;
  }
  
  // Exemple pour ajouter des données de rapport
  addReportRow("03/01/2023", 1200, 600, 600);
  addReportRow("04/01/2023", 1800, 800, 1000);
  