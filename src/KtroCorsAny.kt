package it.lamba.ktor.utils

import io.ktor.features.CORS
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod

/**
 * Allows request from any method.
 */
fun CORS.Configuration.anyMethod() =
    HttpMethod.DefaultMethods.forEach { method(it) }

/**
 * Allows request with any header.
 */
fun CORS.Configuration.anyHeader(includeUnsafe: Boolean = true) {
    if (includeUnsafe)
        HttpHeaders.AllHeaders.forEach { header(it) }
    else
        HttpHeaders.AllHeaders.asSequence().filter { !HttpHeaders.isUnsafe(it) }.forEach { header(it) }
}

val HttpHeaders.AllHeaders
    get() = listOf(
        Accept,
        AcceptCharset,
        AcceptEncoding,
        AcceptLanguage,
        AcceptRanges,
        Age,
        Allow,
        ALPN,  // Application-Layer Protocol Negotiation, HTTP/2
        AuthenticationInfo,
        Authorization,
        CacheControl,
        Connection,
        ContentDisposition,
        ContentEncoding,
        ContentLanguage,
        ContentLength,
        ContentLocation,
        ContentRange,
        ContentType,
        Cookie,
        DASL,  // WebDAV Search
        Date,
        DAV,  // WebDAV
        Depth,  // WebDAV
        Destination,
        ETag,
        Expect,
        Expires,
        From,
        Forwarded,
        Host,
        HTTP2Settings,
        If,
        IfMatch,
        IfModifiedSince,
        IfNoneMatch,
        IfRange,
        IfScheduleTagMatch,
        IfUnmodifiedSince,
        LastModified,
        Location,
        LockToken,
        Link,
        MaxForwards,
        MIMEVersion,
        OrderingType,
        Origin,
        Overwrite,
        Position,
        Pragma,
        Prefer,
        PreferenceApplied,
        ProxyAuthenticate,
        ProxyAuthenticationInfo,
        ProxyAuthorization,
        PublicKeyPins,
        PublicKeyPinsReportOnly,
        Range,
        Referrer,
        RetryAfter,
        ScheduleReply,
        ScheduleTag,
        SecWebSocketAccept,
        SecWebSocketExtensions,
        SecWebSocketKey,
        SecWebSocketProtocol,
        SecWebSocketVersion,
        Server,
        SetCookie,
        SLUG,  // Atom Publishing
        StrictTransportSecurity,
        TE,
        Timeout,
        Trailer,
        TransferEncoding,
        Upgrade,
        UserAgent,
        Vary,
        Via,
        Warning,
        WWWAuthenticate,

        // CORS
        AccessControlAllowOrigin,
        AccessControlAllowMethods,
        AccessControlAllowCredentials,
        AccessControlAllowHeaders,

        AccessControlRequestMethod,
        AccessControlRequestHeaders,
        AccessControlExposeHeaders,
        AccessControlMaxAge,

        // Unofficial de-facto headers
        XHttpMethodOverride,
        XForwardedHost,
        XForwardedServer,
        XForwardedProto,
        XForwardedFor,

        XRequestId,
        XCorrelationId,
        XTotalCount,
    )

/**
 * Allows requests from any host, method and header.
 */
fun CORS.Configuration.any(includeUnsafe: Boolean = true) {
    anyHost()
    anyMethod()
    anyHeader(includeUnsafe)
}
