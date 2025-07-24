loadCustomer();

function loadCustomer() {
    fetch("http://localhost:8080/customer/getAll")
        .then(res => res.json())
        .then(data => {
            console.log(data)

            let tableRow = ` 
            
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Salary</th>
            </tr>
        </thead>`;

            let customerTable = document.getElementById("tblCustomer");
            data.forEach(customer => {
                tableRow += `
             <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.salary}</td>
             </tr>
            
              `;

            });

            customerTable.innerHTML = tableRow;
        })
}