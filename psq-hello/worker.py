from main import *
from gcloud import pubsub, datastore
import psq


PROJECT_ID = 'single-object-747'

ps_client = pubsub.Client(project=PROJECT_ID)
ds_client = datastore.Client(dataset_id=PROJECT_ID)

q = psq.Queue(
    ps_client,
    storage=psq.DatastoreStorage(ds_client))

r = q.enqueue(count_words_at_url, 'http://nvie.com')
print r.result()
