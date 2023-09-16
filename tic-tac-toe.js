let started = false;
let turn = 'X';
let count= 0;
let line= document.createElement('div');
document.addEventListener('keypress', function () {
    if (!started) {
        console.log('Game Started !');
        line.setAttribute('class', '');
        line.remove();
        document.querySelectorAll('.board div').forEach(btn=>{btn.innerHTML= '';});
        started = true;
        document.querySelector('h4').innerText = 'Player 1 Turn';
        playGame();
    }
});
document.querySelector('button').addEventListener('click', ()=>{
    document.querySelector('h4').innerHTML= '';
    document.querySelectorAll('.board div').forEach(btn=>{btn.innerHTML= '';});
    line.remove();
    reset();
});

function playGame() {
    if(!started) return;
    let btns = document.querySelectorAll('.board div');
    btns.forEach(btn=> {
        btn.addEventListener('click', playerTurn);
    });
}

function playerTurn(){
    let btn= this;
    let heading = document.querySelector('h4');
    if(!started) return;
    if (btn.innerHTML == '') {
        btn.innerHTML= turn;
        turn = turn == 'X' ? 'O' : 'X';
        count++;
        if (turn == 'X') {
            heading.innerText = "Player 1's Turn";
        }
        else
        heading.innerText = "Player 2's Turn";
    let end= gameEnd();
    if(end){
            line.classList.add(end[1]);
            line.classList.add(end[2]);
            console.log(line.classList);
            document.querySelector('.board').appendChild(line);
            heading.innerHTML = `<u>Player ${turn== 'X'? 2: 1} won!</u>`;
            reset();
        };
    }
    else {
        let text = heading.innerHTML;
        heading.innerText = 'Occupied box';
        setTimeout(()=>{heading.innerHTML= text;}, 1000);
    }
    if(count== 9){
        heading.innerHTML= "<u>Match Draw!</u>";
        reset();
        return;
    }
}

function gameEnd(){
    if (document.querySelector('.box1').innerText!= '' &&document.querySelector('.box1').innerText == document.querySelector('.box2').innerText && document.querySelector('.box1').innerText == document.querySelector('.box3').innerText)
        return [true, 'position1', 'horizontal'];
    if (document.querySelector('.box4').innerText!= '' &&document.querySelector('.box4').innerText == document.querySelector('.box5').innerText && document.querySelector('.box4').innerText == document.querySelector('.box6').innerText)
        return [true, 'position2', 'horizontal'];
    if (document.querySelector('.box7').innerText!= '' &&document.querySelector('.box7').innerText == document.querySelector('.box8').innerText && document.querySelector('.box7').innerText == document.querySelector('.box9').innerText)
        return [true, 'position3', 'horizontal'];
    if (document.querySelector('.box1').innerText!= '' &&document.querySelector('.box1').innerText == document.querySelector('.box4').innerText && document.querySelector('.box1').innerText == document.querySelector('.box7').innerText)
        return [true, 'position4', 'vertical'];
    if (document.querySelector('.box2').innerText!= '' &&document.querySelector('.box2').innerText == document.querySelector('.box5').innerText && document.querySelector('.box2').innerText == document.querySelector('.box8').innerText)
        return [true, 'position5', 'vertical'];
    if (document.querySelector('.box3').innerText!= '' &&document.querySelector('.box3').innerText == document.querySelector('.box6').innerText && document.querySelector('.box3').innerText == document.querySelector('.box9').innerText)
        return [true, 'position6', 'vertical'];
    if (document.querySelector('.box1').innerText!= '' &&document.querySelector('.box1').innerText == document.querySelector('.box5').innerText && document.querySelector('.box1').innerText == document.querySelector('.box9').innerText)
        return [true, 'position7', 'diagonal'];
    if (document.querySelector('.box3').innerText!= '' &&document.querySelector('.box3').innerText == document.querySelector('.box5').innerText && document.querySelector('.box3').innerText == document.querySelector('.box7').innerText)
        return [true, 'position8', 'diagonal'];
    return false;
}

function reset(){
    document.querySelector('h4').innerHTML= `${document.querySelector('h4').innerHTML}<br>Press any key to Continue`;
    started= false;
    count= 0;
    turn= 'X';
}
