package spy;

import com.meituan.common.utils.HttpClientUtils;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GenHeader {

    public static void main(String[] args) {
        String lvxingPullUrl = "http://squirrel.vip.sankuai.com/api/cluster/statsinfo";
        Map<String, String> params = new HashMap<>();
        params.put("clusterName","redis-bike-internal_product");
        params.put("env","product");

        String clientId = "com.sankuai.bikezeus.sms";
        String secret = "7d81454c-cb4e-11ea-9d19-186590ce";
        String res = HttpClientUtils.postWithBA(lvxingPullUrl, params, clientId, secret);
//        String res = "{\"clusterStatsInfo\":{\"clusterName\":\"redis-bike-internal_product\",\"memoryUsedRatio\":84.11,\"memoryUsed\":0.0,\"totalMasterMemory\":60.0,\"totalQPS\":38719,\"totalKeys\":113489762,\"line25\":0,\"failedCount\":0,\"masterSlavePairs\":\"{\\\"masterSlavePairList\\\":[{\\\"master\\\":\\\"10.40.78.91:6379\\\",\\\"slaves\\\":[\\\"10.179.67.135:6379\\\",\\\"10.28.134.124:6379\\\"]},{\\\"master\\\":\\\"10.45.47.11:6379\\\",\\\"slaves\\\":[\\\"10.28.63.215:6379\\\",\\\"10.179.71.167:6379\\\"]},{\\\"master\\\":\\\"10.28.133.59:6379\\\",\\\"slaves\\\":[\\\"10.179.66.199:6379\\\",\\\"10.45.47.108:6379\\\"]},{\\\"master\\\":\\\"10.28.132.53:6379\\\",\\\"slaves\\\":[\\\"10.179.150.211:6379\\\",\\\"10.42.241.151:6379\\\"]},{\\\"master\\\":\\\"10.179.142.157:6379\\\",\\\"slaves\\\":[\\\"10.28.130.16:6379\\\",\\\"10.45.46.182:6379\\\"]}],\\\"allNode\\\":[\\\"10.40.78.91:6379\\\",\\\"10.179.67.135:6379\\\",\\\"10.28.134.124:6379\\\",\\\"10.45.47.11:6379\\\",\\\"10.28.63.215:6379\\\",\\\"10.179.71.167:6379\\\",\\\"10.28.133.59:6379\\\",\\\"10.179.66.199:6379\\\",\\\"10.45.47.108:6379\\\",\\\"10.28.132.53:6379\\\",\\\"10.179.150.211:6379\\\",\\\"10.42.241.151:6379\\\",\\\"10.179.142.157:6379\\\",\\\"10.28.130.16:6379\\\",\\\"10.45.46.182:6379\\\"]}\",\"expires\":112529576,\"inputKbps\":5378.0199999999995,\"outputKbps\":11725.489999999998,\"connectedClients\":3881,\"blockedClients\":0,\"expiredKeys\":2430373414,\"evictedKeys\":0,\"keyspaceHits\":26388123986,\"keyspaceMisses\":28750712796,\"updateTime\":1595411096000},\"info\":{\"bu\":\"单车事业部\",\"childBu\":\"摩拜单车\",\"clusterName\":\"redis-bike-internal_product\",\"commonConfigs\":\"{\\\"configs\\\":{\\\"appendonly\\\":\\\"no\\\",\\\"auto-aof-rewrite-percentage\\\":\\\"0\\\",\\\"hash-max-ziplist-entries\\\":\\\"512\\\",\\\"zset-max-ziplist-entries\\\":\\\"128\\\",\\\"hash-max-ziplist-value\\\":\\\"64\\\",\\\"slowlog-log-slower-than\\\":\\\"1000\\\",\\\"maxmemory\\\":\\\"12884901888\\\",\\\"zset-max-ziplist-value\\\":\\\"64\\\",\\\"repl-backlog-size\\\":\\\"134217728\\\",\\\"slowlog-max-len\\\":\\\"1024\\\",\\\"save\\\":\\\"\\\",\\\"set-max-intset-entries\\\":\\\"512\\\",\\\"appendfsync\\\":\\\"no\\\",\\\"auto-aof-rewrite-min-size\\\":\\\"17179869184\\\",\\\"aof-rewrite-incremental-fsync\\\":\\\"yes\\\",\\\"hz\\\":\\\"60\\\",\\\"maxmemory-policy\\\":\\\"noeviction\\\",\\\"timeout\\\":\\\"120\\\",\\\"client-output-buffer-limit\\\":\\\"normal 33554432 16777216 60 slave 3221225472 1610612736 180 pubsub 33554432 8388608 60 keeper 3221225472 1610612736 180\\\",\\\"header-enabled\\\":\\\"no\\\",\\\"health-enabled\\\":\\\"yes\\\",\\\"cluster-bus-send-ver\\\":\\\"1\\\"}}\",\"applicant\":\"yaobo\",\"applicantName\":\"姚波\",\"description\":\"单车内部系统\",\"masterIdc\":\"兆丰、贤人、光环\",\"slaveIdc\":\"兆丰、贤人、光环\",\"masterCount\":5,\"slaveCount\":10,\"persistence\":false,\"location\":2,\"dba\":\"huangzhenliang\",\"backupDba\":\"dp.wang\",\"dbaName\":\"黄振良\",\"createTime\":\"2019-06-20 21:23:28\",\"canDegrade\":\"Y\",\"canDegradeDesc\":\"是\",\"canDropData\":null,\"canDropDataDesc\":\"\",\"isCashInvolved\":null,\"isCashInvolvedDesc\":\"\",\"isMultiIdc\":\"N\",\"isMultiIdcDesc\":\"否\",\"redisVersion\":\"5.0.1.0\",\"multiIdc\":2,\"clientType\":\"s_java\",\"coreCluster\":\"N\",\"coreClusterDesc\":\"否\",\"coreClusterReason\":\"\",\"operationTime\":\"6,0|23-1\",\"owtId\":464,\"moduleInfo\":null,\"needChangeDataApproval\":\"N\",\"needChangeDataApprovalDesc\":\"否\",\"clusterLevel\":\"S\"}}\n";
        //转换成为JSONObject对象
        JSONObject jsonObj = new JSONObject(res);
        JSONObject clusterStatsInfo = (JSONObject) jsonObj.get("clusterStatsInfo");
        String clusterName = (String) clusterStatsInfo.get("clusterName");
        Double memoryUsedRatio = clusterStatsInfo.getDouble("memoryUsedRatio");
        Double totalMasterMemory = clusterStatsInfo.getDouble("totalMasterMemory");
        Double memoryUsed = memoryUsedRatio*totalMasterMemory*0.01;
        Double totalQPS =  clusterStatsInfo.getDouble("totalQPS");
        Double totalKeys= clusterStatsInfo.getDouble("totalKeys");
//


        System.out.println(memoryUsed);
    }
}
