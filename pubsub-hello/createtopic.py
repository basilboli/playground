from client import *

client = create_pubsub_client()

topic = client.projects().topics().create(
    name='projects/single-object-747/topics/mytopic', body={}).execute()

print 'Created: %s' % topic.get('name')