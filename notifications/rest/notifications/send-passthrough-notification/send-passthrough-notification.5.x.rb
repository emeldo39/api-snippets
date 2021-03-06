# Download the Ruby helper library from twilio.com/docs/libraries/ruby
require 'twilio-ruby'

# Get your Account Sid and Auth Token from https://www.twilio.com/console
# To set up environmental variables, see http://twil.io/secure
account_sid = ENV['TWILIO_ACCOUNT_SID']
auth_token = ENV['TWILIO_AUTH_TOKEN']

client = Twilio::REST::Client.new(account_sid, auth_token)

service = client.notify.v1.services('ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX')

notification = service.notifications.create(
  to_binding: [
    '{"binding_type":"sms", "address":"+15555555555"}',
    '{"binding_type":"facebook-messenger", "address":"123456789123"}'
  ],
  body: 'Hello Bob'
)

puts notification
