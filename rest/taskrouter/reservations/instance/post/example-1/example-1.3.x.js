// Download the Node helper library from twilio.com/docs/node/install
// These consts are your accountSid and authToken from https://www.twilio.com/console
// To set up environmental variables, see http://twil.io/secure
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;
const workspaceSid = 'WSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX';
const taskSid = 'WTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX';
const reservationSid = 'WRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX';
const client = require('twilio')(accountSid, authToken);

// accept a reservation
client.taskrouter.v1
  .workspaces(workspaceSid)
  .tasks(taskSid)
  .reservations(reservationSid)
  .update({
    reservationStatus: 'accepted',
  })
  .then(reservation => {
    console.log(reservation.reservationStatus);
    console.log(reservation.workerName);
  });
