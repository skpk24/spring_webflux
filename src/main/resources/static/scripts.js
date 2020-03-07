const app = document.getElementById('root')

const container = document.createElement('div')
container.setAttribute('class', 'container')

//app.appendChild(logo)
app.appendChild(container)

// Create a request variable and assign a new XMLHttpRequest object to it.
var request = new XMLHttpRequest()

// Open a new connection, using the GET request on the URL endpoint

function doAjax() {
	request.open('GET', '/employees/', true)
	
	request.onload = function() {
	  // Begin accessing JSON data here
		// Begin accessing JSON data here
		var data = JSON.parse(this.response)
		if (request.status >= 200 && request.status < 400) {
			data.forEach(e => {
			  // Log each movie's title
			  console.log(e.id)
			  console.log(e.name)
			  console.log(e.salary)
			  
			  const card = document.createElement('div')
		      card.setAttribute('class', 'card')
		
		      const h1 = document.createElement('h1')
		      h1.textContent = e.id
		
		      const p = document.createElement('p')
		      e.name = e.name
		      p.textContent = `${e.name}...`
		    	  
	    	  const p1 = document.createElement('p')
		      p1.textContent = e.salary 
		
		      container.appendChild(card)
		      card.appendChild(h1)
		      card.appendChild(p)
		      card.appendChild(p1)
			})
			
		}else{
			console.log('error')
			const errorMessage = document.createElement('marquee')
		    errorMessage.textContent = `Gah, it's not working!`
		    app.appendChild(errorMessage)
		}
	}
	
	// Send request
	request.send();
}

setTimeout(doAjax, 100);