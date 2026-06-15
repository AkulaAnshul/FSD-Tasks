import EventEmitter from 'events';

const emitter = new EventEmitter();

emitter.on('userLoggedIn', (user) => {
  console.log(`${user.name} logged in`);
});

emitter.on('userLoggedIn', (user) => {
  console.log(`Welcome ${user.name}`);
});

emitter.on('userLoggedIn', (user) => {
  console.log(`Hope you are having a good day ${user.name}`);
});

function login(user) {
  console.log('Authenticating user');
  emitter.emit('userLoggedIn', user);
}

login({ name:'Rui'});