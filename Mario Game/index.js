const canvas = document.querySelector('canvas')
const c = canvas.getContext('2d')

canvas.width = innerWidth
canvas.height = innerHeight

const gravity = 0.45


class Player {
    constructor(){
        this.position = {
            x:100,
            y:100
        }

        this.velocity = {
            x:0,
            y:0
        }

        this.width = 30

        this.height = 30
        
    }

    draw() {
        c.fillStyle = 'purple'
        c.fillRect(this.position.x, this.position.y, this.width, this.height)
    }
    
    update() {
        this.draw()
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
        if(this.velocity.y + this.position.y + this.height <= canvas.height )
        this.velocity.y += gravity;
        else this.velocity.y = 0
    }
    
}
class PLatform {
    constructor(){
        this.position = {
            x:500,
            y:500
    
        }
        this.width = 200
        this.height = 20
    }
    draw(){
      c.fillStyle = 'blue'
      c.fillRect(this.position.x, this.position.y,this.width,this.height)  
    }
}
const player = new Player() 
const platform =new PLatform()
const keys = {
    right: {
        pressed: false
    },
    left: {
        pressed: false
    }
    
}

function animate (){
    requestAnimationFrame(animate)
    c.clearRect(0, 0, canvas.width, canvas.height)
    player.update()
    platform.draw()

    
    if (keys.right.pressed){
        player.velocity.x = 5
    }else if (keys.left.pressed){
        player.velocity.x = -5
    }else player.velocity.x = 0

    if(player.position.y + player.height <= platform.position.y
        &&
        player.position.y + player.height + player.velocity.y >= platform.position.y){
            player.velocity.y = 0

    }
}

animate()

addEventListener('keydown', ({ key })=> {
    switch(key){

        case 'a': 
            keys.left.pressed = true;
            break

        case 'w':
           if (player.velocity.y >= 0) { 
        player.velocity.y -= 10
      }
            break

        case 'd': 
            keys.right.pressed = true;
            break

        case 's':
            keys.down.pressed += 20;
            break
        
    }
})

addEventListener('keyup', ({ key })=> {
    switch(key){

        //left
        case 'a': 
            keys.left.pressed = false;
            break

        //up
        case 'w':
            player.velocity.y = 0;
            break

        //right
        case 'd': 
            keys.right.pressed = false;
            break

        //down
        case 's':
            player.velocity.y = 0;
            break
        
    }
})

