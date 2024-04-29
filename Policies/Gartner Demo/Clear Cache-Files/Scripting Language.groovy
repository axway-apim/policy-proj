import com.vordel.circuit.cache.CacheContainer
import com.vordel.trace.Trace

def invoke(msg) {
    // The default cache is one of the cache created at install time
    def cacheName = msg.get("cacheName")
    def defaultCache = CacheContainer.getInstance().getCache(cacheName)
    Trace.info("Default Cache : " + (defaultCache != null ? defaultCache.getName() : "null"))

    // Get the EHCache's CacheManager using an instance of a cache
    def cacheManager = defaultCache != null ? defaultCache.getCacheManager() : null
    if (cacheManager != null) {
        Trace.info("Got an instance of EHCache's CacheManager. Flushing selected cache !")
        cacheManager.clearAll();
    }

    // If we got a CacheManager instance, we should have flushed successfully all caches
    return cacheManager != null
}