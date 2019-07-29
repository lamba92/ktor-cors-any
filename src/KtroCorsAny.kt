package it.lamba.ktor.utils

import io.ktor.features.CORS
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod

/**
 * Allows request from every method.
 */
fun CORS.Configuration.anyMethod() = HttpMethod.DefaultMethods.forEach { method(it) }

/**
 * Allows request with every header.
 */
fun CORS.Configuration.anyHeader() {
    HttpHeaders.AllHeaders.forEach { header(it) }
}

val HttpHeaders.AllHeaders
    get() = listOf(
        Accept, AcceptCharset, AcceptEncoding, AcceptLanguage, AcceptRanges,
        Age, Allow, ALPN, AuthenticationInfo, Authorization, CacheControl, Connection,
        ContentDisposition, ContentEncoding, ContentLanguage, ContentLength, ContentLocation,
        ContentRange, ContentType, Cookie, DASL, Date, DAV, Depth, Destination, ETag, Expect,
        Expires, From, Forwarded, Host, HTTP2Settings, If, IfMatch, IfModifiedSince,
        IfNoneMatch, IfRange, IfScheduleTagMatch, IfUnmodifiedSince, LastModified,
        Location, LockToken, Link, MaxForwards, MIMEVersion, OrderingType, Origin,
        Overwrite, Position, Pragma, Prefer, PreferenceApplied, ProxyAuthenticate,
        ProxyAuthenticationInfo, ProxyAuthorization, PublicKeyPins, PublicKeyPinsReportOnly,
        Range, Referrer, RetryAfter, ScheduleReply, ScheduleTag, SecWebSocketAccept,
        SecWebSocketExtensions, SecWebSocketKey, SecWebSocketProtocol, SecWebSocketVersion,
        Server, SetCookie, SLUG, StrictTransportSecurity, TE, Timeout, Trailer,
        TransferEncoding, Upgrade, UserAgent, Vary, Via, Warning, WWWAuthenticate,
        AccessControlAllowOrigin, AccessControlAllowMethods, AccessControlAllowCredentials,
        AccessControlAllowHeaders, AccessControlRequestMethod, AccessControlRequestHeaders,
        AccessControlExposeHeaders, AccessControlMaxAge, XHttpMethodOverride, XForwardedHost,
        XForwardedServer, XForwardedProto, XForwardedFor, XRequestId, XCorrelationId
    )

/**
 * Allows requests from any host, with every method and header.
 */
fun CORS.Configuration.any(includeUnsafe: Boolean = false) {
    anyHost()
    anyMethod()
    anyHeader()
}