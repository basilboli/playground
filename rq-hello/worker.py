from redis import Redis
from rq import Queue
import time

q = Queue(connection=Redis())

from main import count_words_at_url

job = q.enqueue(
             count_words_at_url, 'http://nvie.com')
print job.result 
# Now, wait a while, until the worker is finished
time.sleep(1)
print job.result   # => 889